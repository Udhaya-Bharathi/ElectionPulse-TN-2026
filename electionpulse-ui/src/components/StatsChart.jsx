import {
    PieChart,
    Pie,
    Cell,
    Tooltip,
    Legend
} from "recharts";

function StatsChart({ stats }) {

    const data = [
        {
            name: "Parties",
            value: stats.partyCount
        },
        {
            name: "Regions",
            value: stats.regionCount
        },
        {
            name: "Districts",
            value: stats.districtCount
        }
    ];

    const COLORS = [
        "#0088FE",
        "#00C49F",
        "#FFBB28"
    ];

    return (
        <PieChart width={500} height={300}>
            <Pie
                data={data}
                dataKey="value"
                outerRadius={100}
                label
            >
                {data.map((entry, index) => (
                    <Cell
                        key={index}
                        fill={COLORS[index % COLORS.length]}
                    />
                ))}
            </Pie>

            <Tooltip />
            <Legend />
        </PieChart>
    );
}

export default StatsChart;