import HomeIcon from '@mui/icons-material/Home';
import TravelExploreIcon from '@mui/icons-material/TravelExplore';
import BarChartIcon from '@mui/icons-material/BarChart';
import SettingsIcon from '@mui/icons-material/Settings';
import { ListItemIcon } from '@mui/material';

export const navData = [
    {
        id: 0,
        icon: <BarChartIcon/>,
        text: "Charts",
        link: "/pie-chart"
    },
    {
        id: 1,
        icon: <TravelExploreIcon/>,
        text: "Devices",
        link: "/device-list"
    },
    {
        id: 2,
        icon: <TravelExploreIcon/>,
        text: "User Management",
        link: "/add-user"
    }
]