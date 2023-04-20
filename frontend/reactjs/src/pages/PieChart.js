import React, { useEffect, useState } from "react";
import { Chart } from "react-google-charts";
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import deviceEndpoint from "../rest-endpoints/devicesEndpoint";
import './PieChart.css';

const PieChart = () => {
  const navigate = useNavigate();

  const data = '';

  const chartEvents = [
    {
      callback: ({ chartWrapper, google }) => {
        const chart = chartWrapper.getChart();
        chart.container.addEventListener("click", (ev) => navigate("/device-list"))
      },
      eventName: "ready"
    }
  ];

  const [deviceData, setDeviceData] = useState([["Devices", "Count"]]);

  useEffect(() => {
    const url = deviceEndpoint + '/get/device-counts/' + localStorage.getItem("token");

    const config = {
      method: 'get',
      url: url,
      headers: {},
      data: data
    };

    const getAllDeviceData = () => {
      axios(config)
        .then((response) => {
          const deviceCounts = response.data;
          const pieData = [["Devices", "Count"]];
          for (const deviceCount of deviceCounts) {
            pieData.push(deviceCount);
          }
          setDeviceData(pieData);
        })
        .catch(error => console.log(error));
    }
    getAllDeviceData();
  }, []);

  const pieOptions = {
    title: "Devices",
  };

  return (
    <>
      <div className="pie-chart-container">
        <div className="pie-chart-wrapper">
          <Chart
            chartType="PieChart"
            data={deviceData}
            options={pieOptions}
            width={"100%"}
            height={"400px"}
            chartEvents={chartEvents}
          />
        </div>
      </div>
    </>
  );
}

export default PieChart;
