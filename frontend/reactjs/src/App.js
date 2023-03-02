//import logo from './logo.svg';
import './App.css';
import PieChart from "./pages/PieChart";
import Login from './pages/Login';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DeviceList from './pages/DeviceList';
import AddUser from './pages/AddUser';
import WithNav from './WithNav';
import WithoutNav from './WithoutNav';

const App = () => {
  return (
    <BrowserRouter>
      <div className="App" style={{ marginTop: 5 }}>
        <Routes>
          <Route element={<WithoutNav />}>
            <Route path="/" element={<Login />} />
          </Route>
          <Route element={<WithNav />}>
            <Route path="/pie-chart" element={<PieChart />} />
            <Route path="/device-list" element={<DeviceList />} />
            <Route path="/add-user" element={<AddUser />} />
          </Route>
        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App;
