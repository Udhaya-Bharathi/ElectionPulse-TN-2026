import { useEffect, useState } from "react";
import { getDashboardStats } from "../services/dashboardService";
import StatCard from "../components/StatCard";
import StatsChart from "../components/StatsChart";
function Dashboard() {

    const [stats, setStats] = useState({
        partyCount: 0,
        regionCount: 0,
        districtCount: 0
    });

    useEffect(() => {
        loadStats();
    }, []);

    const loadStats = async () => {
        try {
            const data = await getDashboardStats();
            setStats(data);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div>

            <h1>ElectionPulse Dashboard</h1>

            <div style={{
                display: "flex",
                gap: "20px",
                flexWrap: "wrap"
            }}>

                <StatCard
                    title="Parties"
                    value={stats.partyCount}
                />

                <StatCard
                    title="Regions"
                    value={stats.regionCount}
                />

                <StatCard
                    title="Districts"
                    value={stats.districtCount}
                />
                <StatsChart stats={stats} />
            </div>

        </div>
    );
}

export default Dashboard;