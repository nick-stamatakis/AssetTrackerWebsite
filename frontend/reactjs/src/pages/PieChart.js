import React, { useEffect, useState } from "react";
import { Chart } from "react-google-charts";
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import deviceEndpoint from "../rest-endpoints/devicesEndpoint";
import "./PieChart.css";

const PieChart = () => {
  const navigate = useNavigate();
  
  const data = '';
  const url = deviceEndpoint + '/devices/get/device-counts/';

  const config = {
    method: 'get',
    url: url,
    headers: { },
    data : data
  };

  const chartEvents = [
    {
      callback: ({ chartWrapper, google }) => {
        const chart = chartWrapper.getChart();
        chart.container.addEventListener("click", (ev) => navigate("/device-list"))
      },
      eventName: "ready"
    }
  ];

  const pieData = [["Devices", "Count"]];

  const pieOptions = {
    title: "Devices",
  };

  const [deviceData, getDeviceData] = useState('');

  useEffect(() => {
    getAllDeviceData();
  }, []); 

  const getAllDeviceData = () => {
    axios(config)
    .then((response) => {
      const deviceCounts = response.data;
      for (const deviceCount of deviceCounts) {
        pieData.push(deviceCount);
      }
      getDeviceData(pieData);
    })
    .catch(error => console.log(error));
  }
  
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