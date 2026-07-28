import {
    BarChart,
    Bar,
    XAxis,
    YAxis,
    Tooltip,
    ResponsiveContainer
} from "recharts";

import {
    Paper,
    Typography
} from "@mui/material";

function PartyPieChart({ data }) {

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
                Top Parties by Seats
            </Typography>

            <ResponsiveContainer
                width="100%"
                height="90%"
            >

                <BarChart
                    data={data}
                    layout="vertical"
                    margin={{
                        left: 25
                    }}
                >

                    <XAxis
                        type="number"
                    />

                    <YAxis
                        dataKey="party"
                        type="category"
                    />

                    <Tooltip />

                    <Bar
                        dataKey="seats"
                        radius={[0, 8, 8, 0]}
                    />

                </BarChart>

            </ResponsiveContainer>

        </Paper>

    );

}

export default PartyPieChart;