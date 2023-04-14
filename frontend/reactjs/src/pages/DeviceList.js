import React, { useEffect, useState } from "react";
import axios from 'axios';
import { Chart } from "react-google-charts";
import deviceEndpoint from "../rest-endpoints/devicesEndpoint";

const DeviceList = () => {
    const data = '';
    const url = deviceEndpoint + '/devices/get/device-list/';

    const config = {
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
        allowHtml: true,
        legend: { position: "bottom" }
    };

    const formatters = [
        {
          type: "PatternFormat",
          column: [3, 4],
          options: '<a href="https://www.google.com/maps/place/{0}">{0}</a>'
        },
    ];

    const [deviceData, getDeviceData] = useState('');

    useEffect(() => {
        getAllDeviceData();
    });

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
        <Chart
        chartType="Table"
        width="100%"
        height="400px"
        data={deviceData}
        options={options}
        formatters={formatters}
        />
    </>
    );
}

export default DeviceList;