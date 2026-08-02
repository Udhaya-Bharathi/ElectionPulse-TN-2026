
import { analyzeDistrict } from "../services/aiService";
import ReactMarkdown from "react-markdown";
import { useEffect, useState } from "react";
import { getDistrictNames } from "../services/districtService";
import {
    Paper,
    Typography,
    TextField,
    Button,
    CircularProgress,
    Card,
    CardContent,
    Divider,
    Stack,
    Chip,
    IconButton,
    Tooltip
} from "@mui/material";
import Autocomplete from "@mui/material/Autocomplete";
import SmartToyIcon from "@mui/icons-material/SmartToy";
import ContentCopyIcon from "@mui/icons-material/ContentCopy";

export default function AIAnalysis() {
    const [district, setDistrict] = useState("");
    const [districts, setDistricts] = useState([]);
    const [answer, setAnswer] = useState("");
    const [loading, setLoading] = useState(false);

    const handleAnalyze = async () => {

        if (!district.trim()) return;

        setLoading(true);

        try {

            const response = await analyzeDistrict(district);

            setAnswer(response.answer);

        } catch (e) {

            setAnswer("Unable to analyze district.");

        } finally {

            setLoading(false);

        }
    };
    const suggestions = [
        "Chennai",
        "Coimbatore",
        "Madurai",
        "Salem",
        "Tiruchirappalli"
    ];

    useEffect(() => {
        getDistrictNames()
            .then((data) => {
                setDistricts(data);
            })
            .catch(console.error);
    }, []);
    return (

        <Paper
            sx={{
                p:4,
                borderRadius:4
            }}
        >

            <Typography
                variant="h4"
                fontWeight="bold"
                gutterBottom
            >

                <SmartToyIcon sx={{mr:1}}/>

                ElectionPulse AI Analyst

            </Typography>

            <Typography
                color="text.secondary"
                mb={3}
            >

                Analyze Tamil Nadu Election 2026 using AI.

            </Typography>

            <Stack
                direction="row"
                spacing={2}
                mb={3}
                flexWrap="wrap"
            >

                {suggestions.map((item)=>(

                    <Chip

                        key={item}

                        label={item}

                        clickable

                        color="primary"

                        variant="outlined"

                        onClick={()=>setDistrict(item)}

                    />

                ))}

            </Stack>



            <Autocomplete
                freeSolo
                options={districts}
                value={district}
                onInputChange={(event, newValue) => {
                    setDistrict(newValue || "");
                }}
                onChange={(event, newValue) => {
                    setDistrict(newValue || "");
                }}
                renderInput={(params) => (
                    <TextField
                        {...params}
                        label="Select or Type District"
                        fullWidth
                    />
                )}
            />
            <Button

                sx={{
                    mt:2,
                    borderRadius:3
                }}

                variant="contained"

                onClick={handleAnalyze}
                startIcon={<SmartToyIcon/>}

            >

                Generate AI Report

            </Button>

            <Card
                sx={{
                    mt:4,
                    borderRadius:4,
                    minHeight:250
                }}
            >

                <CardContent>

                    <Stack
                        direction="row"
                        justifyContent="space-between"
                        alignItems="center"
                    >

                        <Typography
                            variant="h6"
                            fontWeight="bold"
                        >

                            📊 AI Election Report

                        </Typography>

                        {
                            answer &&
                            <Tooltip title="Copy">

                                <IconButton

                                    onClick={()=>navigator.clipboard.writeText(answer)}

                                >

                                    <ContentCopyIcon/>

                                </IconButton>

                            </Tooltip>
                        }

                    </Stack>

                    <Divider sx={{my:2}}/>

                    {

                        loading ?

                            <Stack spacing={2} alignItems="center">

                                <CircularProgress/>

                                <Typography>

                                    Analyzing election statistics...

                                </Typography>

                            </Stack>
                            :

                            answer ?

                                <ReactMarkdown
                                    components={{
                                        h1: ({children}) => <Typography variant="h4">{children}</Typography>,
                                        h2: ({children}) => <Typography variant="h5" mt={2}>{children}</Typography>,
                                        p: ({children}) => (
                                            <Typography
                                                paragraph
                                                sx={{lineHeight:1.8}}
                                            >
                                                {children}
                                            </Typography>
                                        ),
                                        li: ({children}) => (
                                            <li>
                                                <Typography>{children}</Typography>
                                            </li>
                                        )
                                    }}
                                >
                                    {answer}
                                </ReactMarkdown>

                                :

                                <Typography color="text.secondary">

                                    Select a district and click Analyze.

                                </Typography>

                    }

                </CardContent>

            </Card>

        </Paper>

    );;

}