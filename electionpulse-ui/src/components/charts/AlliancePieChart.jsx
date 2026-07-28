import {
    PieChart,
    Pie,
    Cell,
    Tooltip,
    Legend,
    ResponsiveContainer
} from "recharts";
// add to imports at the top
import AlliancePieChart from "../components/charts/AlliancePieChart";
import {
    Paper,
    Typography
} from "@mui/material";

const COLORS = [
    "#1976D2",
    "#43A047",
    "#F57C00",
    "#E53935",
    "#8E24AA",
    "#00897B"
];

function AlliancePieChart({ data }) {

    return (

        <Paper
            elevation={3}
            sx={{
                p: 2,
                height: 420
            }}
        >

            <Typography
                variant="h6"
                fontWeight="bold"
                gutterBottom
            >
                Alliance Seat Distribution
            </Typography>

            <ResponsiveContainer
                width="100%"
                height="90%"
            >

                <PieChart>

                    <Pie
                        data={data}
                        dataKey="seats"
                        nameKey="alliance"
                        outerRadius={120}
                        label
                    >

                        {

                            data.map((entry, index) => (

                                <Cell
                                    key={index}
                                    fill={COLORS[index % COLORS.length]}
                                />

                            ))

                        }

                    </Pie>

                    <Tooltip />

                    <Legend />

                </PieChart>

            </ResponsiveContainer>

        </Paper>

    );

}

export default AlliancePieChart;