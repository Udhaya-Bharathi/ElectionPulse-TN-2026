import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";

import Dashboard from "./pages/Dashboard";
import Parties from "./pages/Parties";
import Regions from "./pages/Regions";

function App() {
    return (
        <BrowserRouter>

            <Navbar />

            <Routes>
                <Route path="/" element={<Dashboard />} />
                <Route path="/parties" element={<Parties />} />
                <Route path="/regions" element={<Regions />} />
            </Routes>

        </BrowserRouter>
    );
}

export default App;