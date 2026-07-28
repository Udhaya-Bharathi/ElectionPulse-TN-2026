import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getDistrictDetails } from "../services/analyticsService";
import SummaryCard from "../components/SummaryCard";
// add to imports at the top
import AlliancePieChart from "../components/charts/AlliancePieChart";
import {
    Card,
    CardContent,
    Chip,
    Container,
    Grid,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Typography
} from "@mui/material";
function DistrictDetails() {

    const { districtName } = useParams();

    const [district, setDistrict] = useState(null);

    useEffect(() => {
        loadDistrict();
    }, [districtName]);

    const loadDistrict = async () => {

        try {

            const response = await getDistrictDetails(districtName);

            console.log(response.data);

            setDistrict(response.data);

        } catch (error) {

            console.error(error);

        }

    };

    if (!district) {

        return <h2>Loading...</h2>;

    }
    const getAllianceColor = (alliance) => {

        switch (alliance) {

            case "TVK":
                return "secondary";

            case "SPA":
                return "error";

            case "NDA":
                return "warning";

            case "NTK":
                return "success";

            case "NOTA":
                return "default";

            default:
                return "info";
        }

    };

    const getPartyColor = (party) => {

        switch (party) {

            case "TVK":
                return "secondary";

            case "DMK":
                return "error";

            case "AIADMK":
                return "primary";

            case "BJP":
                return "warning";

            case "PMK":
                return "success";

            case "NTK":
                return "success";

            case "NOTA":
                return "default";

            case "Others":
                return "info";

            default:
                return "default";
        }

    };
    return (

        <Container
            maxWidth="xl"
            sx={{
                mt: 4,
                mb: 6
            }}
        >
            <Typography
                variant="h3"
                fontWeight="bold"
                gutterBottom
            >

                {district.district}

            </Typography>

            <Typography
                variant="subtitle1"
                color="text.secondary"
                sx={{ mb: 4 }}
            >

                Tamil Nadu Assembly Election 2026 Analytics

            </Typography>

                <div
                    style={{
                        display: "flex",
                        gap: "20px",
                        flexWrap: "wrap",
                        marginBottom: "30px"
                    }}
                >

                    <SummaryCard
                        title="Seat Leader"
                        value={`${district.seatLeader} (${district.seatLeaderSeats})`}
                    />

                    <SummaryCard
                        title="Vote Leader"
                        value={`${district.voteLeader} (${district.voteLeaderShare}%)`}
                    />

                    <SummaryCard
                        title="Total Seats"
                        value={district.totalSeats}
                    />

                    <SummaryCard
                        title="Total Votes"
                        value={district.totalVotes.toLocaleString()}
                    />

                    <SummaryCard
                        title="Average Margin"
                        value={district.averageVictoryMargin.toLocaleString()}
                    />

                </div>
            <Typography
                variant="h5"
                fontWeight="bold"
                sx={{
                    mt: 4,
                    mb: 2
                }}
            >

                📊 Alliance Breakdown

            </Typography>
                <Typography
                    variant="h5"
                    fontWeight="bold"
                    sx={{ mb: 2 }}
                >

                </Typography>

                <TableContainer
                    component={Paper}
                    elevation={3}
                    sx={{ mb: 4 }}
                >

                    <Table>

                        <TableHead
                            sx={{
                                backgroundColor: "#1976d2"
                            }}
                        >

                            <TableRow>

                                <TableCell
                                    sx={{
                                        color: "white",
                                        fontWeight: "bold"
                                    }}
                                >
                                    Alliance
                                </TableCell>

                                <TableCell align="center"><b>Seats</b></TableCell>

                                <TableCell align="center"><b>Seat %</b></TableCell>

                                <TableCell align="right"><b>Votes</b></TableCell>

                                <TableCell align="center"><b>Vote %</b></TableCell>

                            </TableRow>

                        </TableHead>

                        <TableBody>

                            {

                                district.allianceBreakdown.map((alliance) => (

                                    <TableRow
                                        key={alliance.alliance}
                                        hover
                                        sx={{
                                            "&:nth-of-type(odd)": {
                                                backgroundColor: "#fafafa"
                                            }
                                        }}
                                    >

                                        <TableCell>

                                            <Chip
                                                label={alliance.alliance}
                                                color={getAllianceColor(alliance.alliance)}
                                                variant="filled"
                                            />

                                        </TableCell>

                                        <TableCell align="center">
                                            {alliance.seats}
                                        </TableCell>

                                        <TableCell align="center">
                                            {alliance.seatShare.toFixed(2)}%
                                        </TableCell>

                                        <TableCell align="right">
                                            {alliance.votes.toLocaleString()}
                                        </TableCell>

                                        <TableCell align="center">
                                            {alliance.voteShare.toFixed(2)}%
                                        </TableCell>

                                    </TableRow>

                                ))

                            }

                        </TableBody>

                    </Table>

                </TableContainer>

            <Typography
                variant="h5"
                fontWeight="bold"
                sx={{
                    mt: 4,
                    mb: 2
                }}
            >

                👥 Party Breakdown
            </Typography>


            <TableContainer
                component={Paper}
                elevation={3}
                sx={{ mb: 4 }}
            >

                <Table>

                    <TableHead
                        sx={{
                            backgroundColor: "#1976d2"
                        }}
                    >

                        <TableRow>

                            <TableCell
                                sx={{
                                    color: "white",
                                    fontWeight: "bold"
                                }}
                            >
                                party
                            </TableCell>

                            <TableCell align="center"><b>Seats</b></TableCell>

                            <TableCell align="center"><b>Seat %</b></TableCell>

                            <TableCell align="right"><b>Votes</b></TableCell>

                            <TableCell align="center"><b>Vote %</b></TableCell>

                        </TableRow>

                    </TableHead>

                    <TableBody>

                        {

                            district.partyBreakdown.map((party) => (

                                <TableRow
                                    key={party.party}
                                    hover
                                    sx={{
                                        "&:nth-of-type(odd)": {
                                            backgroundColor: "#fafafa"
                                        }
                                    }}
                                >

                                    <TableCell>

                                        <Chip
                                            label={party.party}
                                            color={getPartyColor(party.party)}
                                            variant="filled"
                                        />

                                    </TableCell>

                                    <TableCell align="center">
                                        {party.seats}
                                    </TableCell>

                                    <TableCell align="center">
                                        {party.seatShare.toFixed(2)}%
                                    </TableCell>

                                    <TableCell align="right">
                                        {party.votes.toLocaleString()}
                                    </TableCell>

                                    <TableCell align="center">
                                        {party.voteShare.toFixed(2)}%
                                    </TableCell>

                                </TableRow>

                            ))

                        }

                    </TableBody>

                </Table>

            </TableContainer>

            <Typography
                variant="h5"
                fontWeight="bold"
                sx={{
                    mt: 4,
                    mb: 2
                }}
            >
                📍 Constituency Results
            </Typography>

            <TableContainer
                component={Paper}
                elevation={3}
                sx={{ mb: 4 }}
            >

                <Table>

                    <TableHead
                        sx={{
                            backgroundColor: "#1976d2"
                        }}
                    >

                        <TableRow>

                            <TableCell sx={{ color: "white", fontWeight: "bold" }}>
                                Constituency
                            </TableCell>

                            <TableCell sx={{ color: "white", fontWeight: "bold" }}>
                                Winner Candidate
                            </TableCell>

                            <TableCell sx={{ color: "white", fontWeight: "bold" }}>
                                Runner-up Candidate
                            </TableCell>

                            <TableCell
                                align="right"
                                sx={{ color: "white", fontWeight: "bold" }}
                            >
                                Margin
                            </TableCell>

                            <TableCell
                                align="center"
                                sx={{ color: "white", fontWeight: "bold" }}
                            >
                                Margin %
                            </TableCell>

                        </TableRow>

                    </TableHead>

                    <TableBody>

                        {

                            district.constituencies.map((constituency) => (

                                <TableRow
                                    key={constituency.constituency}
                                    hover
                                    sx={{
                                        "&:nth-of-type(odd)": {
                                            backgroundColor: "#fafafa"
                                        }
                                    }}
                                >

                                    <TableCell>

                                        <Typography fontWeight="bold">

                                            {constituency.constituency}

                                        </Typography>

                                    </TableCell>

                                    <TableCell>

                                        <Typography fontWeight="bold">

                                            {constituency.winner}

                                        </Typography>

                                        <Chip
                                            label={constituency.winnerParty}
                                            color={getPartyColor(constituency.winnerParty)}
                                            size="small"
                                            sx={{ mt: 1 }}
                                        />

                                    </TableCell>

                                    <TableCell>

                                        <Typography fontWeight="bold">

                                            {constituency.runnerUp}

                                        </Typography>

                                        <Chip
                                            label={constituency.runnerUpParty}
                                            color={getPartyColor(constituency.runnerUpParty)}
                                            size="small"
                                            sx={{ mt: 1 }}
                                        />

                                    </TableCell>

                                    <TableCell align="right">

                                        {constituency.marginVotes.toLocaleString()} votes

                                    </TableCell>

                                    <TableCell align="center">

                                        {constituency.marginPercentage.toFixed(2)}%

                                    </TableCell>

                                </TableRow>

                            ))

                        }

                    </TableBody>

                </Table>

            </TableContainer>


            <Typography
                variant="h5"
                fontWeight="bold"
                sx={{
                    mt: 4,
                    mb: 2
                }}
            >
                🏆 Election Highlights
            </Typography>

            <Grid
                container
                spacing={3}
            >

                <Grid size={{ xs: 12, md: 6 }}>

                    <Card
                        elevation={4}
                        sx={{
                            borderRadius: 3,
                            height: "100%"
                        }}
                    >

                        <CardContent>

                            <Typography
                                variant="h6"
                                color="success.main"
                                gutterBottom
                            >
                                🏆 Largest Victory
                            </Typography>

                            <Typography
                                variant="h5"
                                fontWeight="bold"
                            >
                                {district.largestVictory.constituency}
                            </Typography>

                            <Typography sx={{ mt: 2 }}>

                                Winner:
                                {" "}
                                {district.largestVictory.winner}

                            </Typography>

                            <Chip
                                label={district.largestVictory.winnerParty}
                                color={getPartyColor(district.largestVictory.winnerParty)}
                                sx={{ mt: 1 }}
                            />

                            <Typography sx={{ mt: 2 }}>

                                Margin:
                                {" "}
                                {district.largestVictory.marginVotes.toLocaleString()} votes

                            </Typography>

                            <Typography>

                                Margin %:
                                {" "}
                                {district.largestVictory.marginPercentage.toFixed(2)}%

                            </Typography>

                        </CardContent>

                    </Card>

                </Grid>

                <Grid size={{ xs: 12, md: 6 }}>

                    <Card
                        elevation={4}
                        sx={{
                            borderRadius: 3,
                            height: "100%"
                        }}
                    >

                        <CardContent>

                            <Typography
                                variant="h6"
                                color="warning.main"
                                gutterBottom
                            >
                                ⚡ Closest Contest
                            </Typography>

                            <Typography
                                variant="h5"
                                fontWeight="bold"
                            >
                                {district.closestContest.constituency}
                            </Typography>

                            <Typography sx={{ mt: 2 }}>

                                Winner:
                                {" "}
                                {district.closestContest.winner}

                            </Typography>

                            <Chip
                                label={district.closestContest.winnerParty}
                                color={getPartyColor(district.closestContest.winnerParty)}
                                sx={{ mt: 1 }}
                            />

                            <Typography sx={{ mt: 2 }}>

                                Margin:
                                {" "}
                                {district.closestContest.marginVotes.toLocaleString()} votes

                            </Typography>

                            <Typography>

                                Margin %:
                                {" "}
                                {district.closestContest.marginPercentage.toFixed(2)}%

                            </Typography>

                        </CardContent>

                    </Card>

                </Grid>

            </Grid>


        </Container>

    );

}

export default DistrictDetails;