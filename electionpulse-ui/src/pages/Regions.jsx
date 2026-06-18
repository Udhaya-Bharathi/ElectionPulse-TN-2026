import { useEffect, useState } from "react";
import { getAllRegions } from "../services/regionService";

function Regions() {

    const [regions, setRegions] = useState([]);

    useEffect(() => {
        loadRegions();
    }, []);

    const loadRegions = async () => {
        try {
            const data = await getAllRegions();
            setRegions(data);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div>
            <h1>Regions</h1>

            {regions.map(region => (
                <div key={region.id}>
                    <p>
                        {region.id} - {region.name}
                    </p>
                </div>
            ))}
        </div>
    );
}

export default Regions;