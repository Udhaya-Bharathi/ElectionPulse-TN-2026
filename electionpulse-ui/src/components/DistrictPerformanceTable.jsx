import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import { getDistrictPerformance } from "../services/analyticsService";

import {
    Box,
    Button,
    Chip,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Typography
} from "@mui/material";

import ArrowForwardIcon from "@mui/icons-material/ArrowForward";

function DistrictPerformanceTable() {

    const [districts, setDistricts] = useState([]);

    const navigate = useNavigate();

    useEffect(() => {

        loadDistricts();

    }, []);

    const loadDistricts = async () => {

        try {

            const response = await getDistrictPerformance();

            setDistricts(response.data);

        }

        catch (error) {

            console.error(error);

        }

    };

    return (

        <Box sx={{ mt: 5 }}>

            <Typography
                variant="h5"
                fontWeight="bold"
                gutterBottom
            >
                District Performance
            </Typography>

            <Typography
                variant="body2"
                color="text.secondary"
                sx={{ mb: 2 }}
            >
                Seat leaders and vote leaders across all districts.
            </Typography>

            <TableContainer
                component={Paper}
                elevation={3}
            >

                <Table>

                    <TableHead>

                        <TableRow
                            sx={{
                                backgroundColor: "#1565C0"
                            }}
                        >

                            <TableCell sx={{ color: "white", fontWeight: "bold" }}>
                                District
                            </TableCell>

                            <TableCell sx={{ color: "white", fontWeight: "bold" }}>
                                Seat Leader
                            </TableCell>

                            <TableCell
                                align="center"
                                sx={{ color: "white", fontWeight: "bold" }}
                            >
                                Seats
                            </TableCell>

                            <TableCell sx={{ color: "white", fontWeight: "bold" }}>
                                Vote Leader
                            </TableCell>

                            <TableCell
                                align="center"
                                sx={{ color: "white", fontWeight: "bold" }}
                            >
                                Vote %
                            </TableCell>

                            <TableCell
                                align="center"
                                sx={{ color: "white", fontWeight: "bold" }}
                            >
                                Details
                            </TableCell>

                        </TableRow>

                    </TableHead>

                    <TableBody>

                        {

                            districts.map((district) => (

                                <TableRow
                                    key={district.district}
                                    hover
                                >

                                    <TableCell>

                                        <Typography
                                            fontWeight="600"
                                        >
                                            {district.district}
                                        </Typography>

                                    </TableCell>

                                    <TableCell>

                                        <Chip
                                            label={district.seatLeader}
                                            color="primary"
                                            size="small"
                                        />

                                    </TableCell>

                                    <TableCell align="center">

                                        <Typography
                                            fontWeight="bold"
                                        >
                                            {district.seatLeaderSeats}
                                        </Typography>

                                    </TableCell>

                                    <TableCell>

                                        <Chip
                                            label={district.voteLeader}
                                            color="success"
                                            size="small"
                                        />

                                    </TableCell>

                                    <TableCell
                                        align="center"
                                    >

                                        {district.voteLeaderShare}%

                                    </TableCell>

                                    <TableCell
                                        align="center"
                                    >

                                        <Button
                                            variant="contained"
                                            size="small"
                                            endIcon={<ArrowForwardIcon />}
                                            onClick={() =>
                                                navigate(
                                                    `/district/${district.district}`
                                                )
                                            }
                                        >
                                            View
                                        </Button>

                                    </TableCell>

                                </TableRow>

                            ))

                        }

                    </TableBody>

                </Table>

            </TableContainer>

        </Box>

    );

}

export default DistrictPerformanceTable;