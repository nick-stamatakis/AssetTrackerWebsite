//import logo from './logo.svg';
import './App.css';
import PieChart from "./pages/PieChart";
import Login from './pages/Login';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DeviceList from './pages/DeviceList';

function App() {
  return (
    <BrowserRouter>
      <div className="App" style={{ marginTop: 5 }}>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/pie-chart" element={<PieChart />} />
          <Route path="/device-list" element={<DeviceList />} />
        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App;
