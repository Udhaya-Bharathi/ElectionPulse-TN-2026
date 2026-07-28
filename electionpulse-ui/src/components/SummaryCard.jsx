import { Card, CardContent, Typography } from "@mui/material";

function SummaryCard({ title, value }) {
    return (
        <Card
            elevation={5}
            sx={{
                borderRadius: 3,
                height: "100%",
                transition: "0.3s",
                "&:hover": {
                    transform: "translateY(-4px)",
                    boxShadow: 8
                }
            }}
        >
            <CardContent>

                <Typography
                    variant="overline"
                    color="text.secondary"
                >
                    {title}
                </Typography>

                <Typography
                    variant="h4"
                    fontWeight="bold"
                    sx={{ mt: 1 }}
                >
                    {value}
                </Typography>

            </CardContent>
        </Card>
    );
}

export default SummaryCard;