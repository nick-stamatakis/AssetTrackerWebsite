import React from 'react';
import Sidenav from './Components/Sidenav';
import { Outlet } from 'react-router';

export default () => {
  return (
    <>
      <Sidenav />
      <Outlet />
    </>
  );
};