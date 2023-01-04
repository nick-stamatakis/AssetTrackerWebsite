import React, { useEffect, useState } from "react";
import axios from 'axios';
import { Chart } from "react-google-charts";
import { useNavigate } from "react-router-dom";

export function DeviceList() {
    let navigate = useNavigate();

    var data = '';
    var url = 'http://34.172.72.72:8082/api/devices/get/device-list/';

    var config = {
        method: 'get',
        url: url,
        headers: { },
        data : data
    };
    
    const deviceListData = [
        ["Name", "UUID", "Model", "Location", "Status", "Type"]
    ];
    
    const options = {
        title: "Company Performance",
        curveType: "function",
        legend: { position: "bottom" }
    };

    const [deviceData, getDeviceData] = useState('');

    useEffect(() => {
        getAllDeviceData();
    }, []);

    const getAllDeviceData = () => {
        axios(config)
        .then((response) => {
            const deviceList = response.data;
            for (var i = 0; i < deviceList.length; i++) {
                const tempList = Object.values(deviceList[i]);
                [tempList[0], tempList[1]] = [tempList[1], tempList[0]];
                deviceListData.push(tempList);
            }
            getDeviceData(deviceListData);
        })
        .catch(error => console.log(error));
    }

    return (
    <>
        <button onClick={() => navigate('/pie-chart')}>Back</button>
        <Chart
        chartType="Table"
        width="100%"
        height="400px"
        data={deviceData}
        options={options}
        />
    </>
    );
}

export default DeviceList;