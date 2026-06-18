import { Link } from "react-router-dom";

function Navbar() {
    return (
        <nav>
            <Link to="/">Dashboard</Link>
            {" | "}
            <Link to="/parties">Parties</Link>
            {" | "}
            <Link to="/regions">Regions</Link>
        </nav>
    );
}

export default Navbar;