import DevicesIcon from '@mui/icons-material/Devices';
import PieChartOutlineIcon from '@mui/icons-material/PieChartOutline';
import ManageAccountsIcon from '@mui/icons-material/ManageAccounts';
import SettingsIcon from '@mui/icons-material/Settings';

export const navData = [
    {
        id: 0,
        icon: <PieChartOutlineIcon/>,
        text: "Charts",
        link: "/pie-chart"
    },
    {
        id: 1,
        icon: <DevicesIcon/>,
        text: "Devices",
        link: "/device-list"
    },
    {
        id: 2,
        icon: <ManageAccountsIcon/>,
        text: "User Management",
        link: "/add-user"
    },
    {
        id: 3,
        icon: <SettingsIcon/>,
        text: "Settings",
        link: "/settings"
    }
]