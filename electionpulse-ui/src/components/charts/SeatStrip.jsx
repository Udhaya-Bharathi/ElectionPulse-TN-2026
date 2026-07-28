import { Box, Paper, Typography, Tooltip } from "@mui/material";

function SeatStrip({
                       title,
                       data,
                       totalSeats = 234
                   }) {

    const colors = [
        "#8B0000",
        "#E53935",
        "#2E7D32",
        "#F9A825",
        "#1E88E5",
        "#6A1B9A",
        "#00897B",
        "#5D4037",
        "#546E7A",
        "#9E9E9E"
    ];

    return (

        <Paper
            elevation={3}
            sx={{
                p: 3,
                borderRadius: 3
            }}
        >

            <Typography
                variant="h6"
                fontWeight="bold"
                gutterBottom
            >
                {title}
            </Typography>
            <Box
                sx={{
                    display: "flex",
                    width: "100%",
                    height: 50,
                    borderRadius: "12px",
                    overflow: "hidden",
                    boxShadow: "0 2px 8px rgba(0,0,0,0.15)"
                }}
            >
                {data.map((item, index) => {

                    const percent = (item.seats / totalSeats) * 100;

                    return (
                        <Tooltip
                            key={item.name}
                            title={`${item.name} • ${item.seats} Seats (${percent.toFixed(1)}%)`}
                        >
                            <Box
                                sx={{
                                    width: `${percent}%`,
                                    backgroundColor: colors[index % colors.length],
                                    display: "flex",
                                    alignItems: "center",
                                    justifyContent: "center",
                                    color: "#fff",
                                    fontWeight: 700,
                                    fontSize: percent > 8 ? 18 : 12,
                                    transition: "0.3s"
                                }}
                            >
                                {percent > 8 ? item.seats : ""}
                            </Box>
                        </Tooltip>
                    );

                })}
            </Box>


            <Box
                sx={{
                    display: "flex",
                    mt: 1
                }}
            >
                {data.map((item, index) => {

                    const percent = (item.seats / totalSeats) * 100;

                    return (
                        <Box
                            key={item.name}
                            sx={{
                                width: `${percent}%`,
                                textAlign: "center"
                            }}
                        >
                            <Typography
                                variant="body2"
                                fontWeight="bold"
                                color={colors[index % colors.length]}
                            >
                                {percent > 5 ? item.name : ""}
                            </Typography>
                        </Box>
                    );

                })}
            </Box>

            <Typography
                align="right"
                sx={{
                    mt: 2,
                    color: "text.secondary"
                }}
            >
                Total Seats : {totalSeats}
            </Typography>

        </Paper>

    );

}

export default SeatStrip;