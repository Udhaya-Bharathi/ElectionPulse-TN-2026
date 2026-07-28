import {
    PieChart,
    Pie,
    Cell,
    ResponsiveContainer,
    Tooltip,
    Legend
} from "recharts";

import { Paper, Typography } from "@mui/material";

const COLORS = [
    "#1565C0",
    "#43A047",
    "#EF6C00",
    "#8E24AA",
    "#E53935",
    "#00897B",
    "#6D4C41",
    "#3949AB",
    "#C0CA33",
    "#5E35B1",
    "#00ACC1",
    "#FB8C00",
    "#546E7A",
    "#9E9E9E",
    "#212121"
];

export default function AnalyticsPieChart({

                                              title,
                                              data,
                                              nameKey,
                                              valueKey

                                          }) {

    return (

        <Paper
            elevation={3}
            sx={{
                p:3,
                borderRadius:3,
                height:450
            }}
        >

            <Typography
                variant="h6"
                fontWeight="bold"
                gutterBottom
            >
                {title}
            </Typography>

            <ResponsiveContainer
                width="100%"
                height={360}
            >

                <PieChart>

                    <Pie

                        data={data}
                        dataKey={valueKey}
                        nameKey={nameKey}
                        cx="50%"
                        cy="50%"
                        outerRadius={120}
                        label={({percent})=>
                            `${(percent*100).toFixed(1)}%`
                        }

                    >

                        {data.map((entry,index)=>(

                            <Cell
                                key={index}
                                fill={
                                    COLORS[
                                    index%COLORS.length
                                        ]
                                }
                            />

                        ))}

                    </Pie>

                    <Tooltip
                        formatter={(value)=>`${value}%`}
                    />

                    <Legend/>

                </PieChart>

            </ResponsiveContainer>

        </Paper>

    );

}