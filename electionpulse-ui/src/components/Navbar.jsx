import { useState } from "react";
import { Link, useLocation } from "react-router-dom";

import {
    AppBar,
    Box,
    Button,
    Menu,
    MenuItem,
    Toolbar,
    Typography
} from "@mui/material";

function Navbar() {

    const location = useLocation();

    const [anchorEl, setAnchorEl] = useState(null);
    const [selectedElection, setSelectedElection] = useState("Assembly 2026");

    const menuItems = [
        {
            label: "Dashboard",
            path: "/"
        },
        {
            label: "Parties",
            path: "/parties"
        },
        {
            label: "Regions",
            path: "/regions"
        },
        {
            label: "AI Analyst",
            path: "/ai"
        }
    ];

    const openMenu = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const closeMenu = () => {
        setAnchorEl(null);
    };

    const chooseElection = (value) => {
        setSelectedElection(value);
        closeMenu();
    };

    return (

        <AppBar
            position="sticky"
            elevation={2}
            sx={{ backgroundColor: "#1565C0" }}
        >

            <Toolbar>

                <Typography
                    variant="h5"
                    fontWeight="bold"
                    sx={{ flexGrow: 1 }}
                >
                    🗳 ElectionPulse
                </Typography>

                <Box>

                    {

                        menuItems.map((item) => (

                            <Button
                                key={item.path}
                                component={Link}
                                to={item.path}
                                color="inherit"
                                sx={{
                                    mx: 1,
                                    borderBottom:
                                        location.pathname === item.path
                                            ? "2px solid white"
                                            : "none",
                                    borderRadius: 0
                                }}
                            >

                                {item.label}

                            </Button>

                        ))

                    }

                    <Button
                        color="inherit"
                        onClick={openMenu}
                        sx={{ ml: 2 }}
                    >

                        {selectedElection} ▼

                    </Button>

                    <Menu
                        anchorEl={anchorEl}
                        open={Boolean(anchorEl)}
                        onClose={closeMenu}
                    >

                        <MenuItem disabled>
                            <strong>Assembly Elections</strong>
                        </MenuItem>

                        <MenuItem
                            onClick={() =>
                                chooseElection("Assembly 2026")
                            }
                        >
                            2026
                        </MenuItem>

                        <MenuItem
                            onClick={() =>
                                chooseElection("Assembly 2021")
                            }
                        >
                            2021
                        </MenuItem>

                        <MenuItem disabled>
                            <strong>Lok Sabha Elections</strong>
                        </MenuItem>

                        <MenuItem
                            onClick={() =>
                                chooseElection("Lok Sabha 2024")
                            }
                        >
                            2024
                        </MenuItem>

                        <MenuItem
                            onClick={() =>
                                chooseElection("Lok Sabha 2019")
                            }
                        >
                            2019
                        </MenuItem>

                    </Menu>

                </Box>

            </Toolbar>

        </AppBar>

    );

}

export default Navbar;