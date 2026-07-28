import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AlliancePieChart from "../components/charts/AlliancePieChart";
import PartyPieChart from "../components/charts/PartyPieChart.jsx";
import {
    getAlliancePerformance,
    getPartyPerformance,
    getAllianceVoteShare,
    getPartyVoteShare
} from "../services/analyticsService";
import Grid from "@mui/material/Grid";
import {
    Autocomplete,
    Box,
    Button,
    Container,
    TextField,
    Typography
} from "@mui/material";

import { getDashboardStats } from "../services/dashboardService";
import { getDistrictNames } from "../services/districtService";

import StatCard from "../components/StatCard";

import DistrictPerformanceTable from "../components/DistrictPerformanceTable";
import SeatStrip from "../components/charts/SeatStrip";
import AnalyticsPieChart from "../components/charts/AnalyticsPieChart";

function Dashboard() {

    const navigate = useNavigate();

    const [stats, setStats] = useState({
        regions: 0,
        districts: 0,
        constituencies: 0,
        parties: 0,
        alliances: 0,
        candidates: 0
    });

    const [districts, setDistricts] = useState([]);
    const [selectedDistrict, setSelectedDistrict] = useState(null);







    const [allianceData, setAllianceData] = useState([]);
    const [partyData, setPartyData] = useState([]);

    const [allianceVoteData, setAllianceVoteData] = useState([]);
    const [partyVoteData, setPartyVoteData] = useState([]);
    useEffect(() => {

        loadStats();
        loadDistricts();
        loadCharts();

    }, []);
    const loadStats = async () => {

        try {

            const response = await getDashboardStats();

            setStats(response.data);

        } catch (error) {

            console.error(error);

        }

    };
    const loadCharts = async () => {

        try {

            const [
                alliance,
                parties,
                allianceVotes,
                partyVotes
            ] = await Promise.all([
                getAlliancePerformance(),
                getPartyPerformance(),
                getAllianceVoteShare(),
                getPartyVoteShare()
            ]);

            setAllianceData(alliance);
            setPartyData(parties);
            setAllianceVoteData(allianceVotes);
            setPartyVoteData(partyVotes);
            console.log("Alliance Seats", alliance);
            console.log("Party Seats", parties);
            console.log("Alliance Votes", allianceVotes);
            console.log("Party Votes", partyVotes);
            setAllianceStripData(
                alliance.map(item => ({
                    name: item.alliance,
                    seats: item.seats
                }))
            );

            setPartyStripData(
                parties.map(item => ({
                    name: item.party,
                    seats: item.seats
                }))
            );

        } catch (err) {

            console.error(err);

        }

    };

    const loadDistricts = async () => {

        try {

            const data = await getDistrictNames();

            setDistricts(data);

        } catch (error) {

            console.error(error);

        }


    };
    const [allianceStripData, setAllianceStripData] = useState([]);
    const [partyStripData, setPartyStripData] = useState([]);
    return (

        <Container maxWidth="xl">

            {/* HERO SECTION */}

            <Box
                sx={{
                    background: "linear-gradient(135deg,#1565C0,#42A5F5)",
                    color: "white",
                    borderRadius: 4,
                    p: 6,
                    mt: 4,
                    mb: 5,
                    textAlign: "center"
                }}
            >

                <Typography
                    variant="h2"
                    fontWeight="bold"
                >
                    🗳 ElectionPulse
                </Typography>

                <Typography
                    variant="h5"
                    sx={{ mt: 2 }}
                >
                    Tamil Nadu Assembly Election Analytics Platform
                </Typography>

                <Typography
                    sx={{
                        mt: 3,
                        fontSize: 18,
                        maxWidth: 800,
                        mx: "auto"
                    }}
                >
                    Explore constituency results, alliance performance,
                    district analytics and election insights through an
                    interactive dashboard.
                </Typography>

                <Autocomplete
                    options={districts}
                    value={selectedDistrict}
                    onChange={(event, value) => {

                        setSelectedDistrict(value);

                        if (value) {

                            navigate(`/district/${value}`);

                        }

                    }}
                    sx={{
                        width: 450,
                        mx: "auto",
                        mt: 4,
                        mb: 3,
                        backgroundColor: "white",
                        borderRadius: 2
                    }}
                    renderInput={(params) => (

                        <TextField
                            {...params}
                            label="Search District"
                            placeholder="Type Chennai..."
                        />

                    )}
                />

                <Button
                    variant="contained"
                    size="large"
                    sx={{
                        bgcolor: "white",
                        color: "#1565C0",
                        fontWeight: "bold",
                        px: 4,
                        py: 1.5,
                        "&:hover": {
                            bgcolor: "#eeeeee"
                        }
                    }}
                >
                    Explore District Analytics
                </Button>

            </Box>

            {/* SUMMARY CARDS */}

            <div
                style={{
                    display: "flex",
                    gap: "20px",
                    flexWrap: "wrap",
                    marginBottom: "30px"
                }}
            >

                <StatCard
                    title="Regions"
                    value={stats.regions}
                />

                <StatCard
                    title="Districts"
                    value={stats.districts}
                />

                <StatCard
                    title="Constituencies"
                    value={stats.constituencies}
                />

                <StatCard
                    title="Parties"
                    value={stats.parties}
                />

                <StatCard
                    title="Alliances"
                    value={stats.alliances}
                />

                <StatCard
                    title="Candidates"
                    value={stats.candidates}
                />

            </div>

            {/* CHART */}

            <Grid container spacing={4} sx={{ mt: 3 }}>

                <Grid size={{ xs: 12, md: 6 }}>

                    <SeatStrip
                        title="Alliance Assembly Composition"
                        data={allianceStripData}
                    />

                    <Box sx={{ mt: 3 }}>
                        <AnalyticsPieChart
                            title="Alliance Vote Share (%)"
                            data={allianceVoteData}
                            nameKey="alliance"
                            valueKey="voteShare"
                        />
                        <Box sx={{ mt:3 }}>

                            <AnalyticsPieChart
                                title="Alliance Seat Share (%)"
                                data={
                                    allianceData.map(item=>({

                                        alliance:item.alliance,
                                        voteShare:Number(
                                            ((item.seats/234)*100)
                                                .toFixed(2)
                                        )

                                    }))
                                }
                                nameKey="alliance"
                                valueKey="voteShare"
                            />

                        </Box>
                    </Box>

                </Grid>

                <Grid size={{ xs: 12, md: 6 }}>

                    <SeatStrip
                        title="Party Assembly Composition"
                        data={partyStripData}
                    />

                    <Box sx={{ mt: 3 }}>
                        <AnalyticsPieChart
                            title="Party Vote Share (%)"
                            data={partyVoteData}
                            nameKey="party"
                            valueKey="voteShare"
                        />
                        <Box sx={{ mt:3 }}>

                            <AnalyticsPieChart
                                title="Party Seat Share (%)"
                                data={
                                    partyData.map(item=>({

                                        party:item.party,
                                        voteShare:Number(
                                            ((item.seats/234)*100)
                                                .toFixed(2)
                                        )

                                    }))
                                }
                                nameKey="party"
                                valueKey="voteShare"
                            />

                        </Box>
                    </Box>

                </Grid>

            </Grid>

            {/* DISTRICT TABLE */}

            <DistrictPerformanceTable />

        </Container>

    );

}

export default Dashboard;