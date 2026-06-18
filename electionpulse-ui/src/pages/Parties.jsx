import { useEffect, useState } from "react";
import { getAllParties } from "../services/partyService";

function Parties() {

    const [parties, setParties] = useState([]);

    useEffect(() => {
        loadParties();
    }, []);

    const loadParties = async () => {
        try {
            const data = await getAllParties();
            console.log(data);
            setParties(data);
        } catch (error) {
            console.error("Error fetching parties", error);
        }
    };

    return (
        <div>
            <h1>Political Parties</h1>

            {parties.map((party) => (
                <div key={party.id}>
                    <p>
                        {party.id} - {party.shortname} - {party.fullname}
                    </p>
                </div>
            ))}
        </div>
    );
}

export default Parties;