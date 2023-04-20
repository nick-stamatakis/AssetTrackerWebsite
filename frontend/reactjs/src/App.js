//import logo from './logo.svg';
import './App.css';
import PieChart from "./pages/PieChart";
import Login from './pages/Login';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DeviceTable from './pages/DeviceTable';
import AddUser from './pages/AddUser';
import WithNav from './WithNav';
import WithoutNav from './WithoutNav';
import Settings from './pages/Settings';
import { ThemeProvider} from '@mui/material';
import { createTheme } from "@mui/material/styles";

const App = () => {
  return (
    <ThemeProvider theme={createTheme()}>
      <BrowserRouter>
        <div className="App" style={{ marginTop: 5 }}>
          <Routes>
            <Route element={<WithoutNav />}>
              <Route path="/" element={<Login />} />
            </Route>
            <Route element={<><WithNav /></>}>
              <Route path="/pie-chart" element={<PieChart />} />
              <Route path="/device-list" element={<DeviceTable />} />
              <Route path="/add-user" element={<AddUser />} />
              <Route path="/settings" element={<Settings />} />
            </Route>
          </Routes>
        </div>
      </BrowserRouter>
    </ThemeProvider>
  )
}

export default App;
