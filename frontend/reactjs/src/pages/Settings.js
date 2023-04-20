import { Checkbox, FormControlLabel, FormGroup, Box } from "@mui/material";
import './Settings.css';

const Settings = () => {
    const checkboxes = [
        { label: "Location", checked: true },
        { label: "Connection Status", checked: true },
        { label: "Battery Status", checked: true },
    ];

    const numCheckboxes = checkboxes.length;

    return (
        <div className="settings-container">
            <Box sx={{borderRadius: "7px", width: "450px", height: numCheckboxes * 48 + 100, backgroundColor: "white" }}>
                <h1>Check columns to display</h1>
                <FormGroup>
                    {checkboxes.map((checkbox) => (
                        <FormControlLabel
                            key={checkbox.label}
                            control={<Checkbox defaultChecked={checkbox.checked} />}
                            label={checkbox.label}
                        />
                    ))}
                </FormGroup>
            </Box>
        </div>
    );
};

export default Settings;
