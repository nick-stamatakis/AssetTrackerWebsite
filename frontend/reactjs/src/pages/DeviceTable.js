import React, { useEffect, useState } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from 'axios';
import deviceEndpoint from '../rest-endpoints/devicesEndpoint';
import './DeviceTable.css';

const DeviceTable = () => {
  const data = '';

  const [deviceColumns, setDeviceColumns] = useState([]);
  const [deviceRows, setDeviceRows] = useState([]);

  useEffect(() => {
    const url = deviceEndpoint + '/get/device-list/' + localStorage.getItem('token');
    const config = {
      method: 'get',
      url: url,
      headers: {},
      data: data
    };

    const getAllDeviceData = () => {
      axios(config)
        .then((response) => {
          const deviceList = response.data;
          const tempList = Object.values(deviceList);
  
          const rows = tempList.map((device, index) => {
            const updated = Object.entries(device).reduce(
              (updated, [key, value]) => {
                const newKey = key.replace(/ /g, '');
                return {
                  ...updated,
                  [newKey]: value,
                };
              },
              {}
            );
            return { ...updated, id: index + 1 };
          });
  
          const columns = Object.keys(deviceList[0]).map((header) => {
            if (header === "Location") {
              return {
                field: header.replace(/ /g, ""),
                headerName: <span style={{fontWeight: 'bold'}}>{header}</span>,
                width: 180,
                renderCell: (params) => (
                  <a href={`https://www.google.com/maps/search/?api=1&query=${encodeURIComponent(params.value)}`} target="_blank" rel="noreferrer">
                    {params.value}
                  </a>
                ),
                headerClassName: 'bold-header MuiDataGrid-colCellTitle', // add MuiDataGrid-colCellTitle here
              };
            }
            return {
              field: header.replace(/ /g, ""),
              headerName: <span style={{fontWeight: 'bold'}}>{header}</span>,
              width: 180,
              headerClassName: 'bold-header', // add MuiDataGrid-colCellTitle here
            };
          });
          
  
          setDeviceColumns(columns);
          setDeviceRows(rows);
        })
        .catch((error) => console.log(error));
    };
    getAllDeviceData();
  }, []);

  return (
    <div style={{ width: '100%' }}>
      <style>
        {`
          .bold-header {
            font-weight: bold !important;
          }
        `}
      </style>
      <DataGrid rows={deviceRows} columns={deviceColumns} pageSize={5} sx={{ backgroundColor: 'white' }} />
    </div>
  );

};

export default DeviceTable;
