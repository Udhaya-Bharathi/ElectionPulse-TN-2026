import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";

import Dashboard from "./pages/Dashboard";
import Parties from "./pages/Parties";
import Regions from "./pages/Regions";
import DistrictDetails from "./pages/DistrictDetails";
import AIAnalysis from "./pages/AIAnalysis";
function App() {
    return (
        <BrowserRouter>

            <Navbar />

            <Routes>
                <Route path="/" element={<Dashboard />} />
                <Route path="/parties" element={<Parties />} />
                <Route path="/regions" element={<Regions />} />
                <Route
                    path="/district/:districtName"
                    element={<DistrictDetails />}
                />
                <Route
                    path="/ai"
                    element={<AIAnalysis/>}
                />
            </Routes>

        </BrowserRouter>
    );
}

export default App;