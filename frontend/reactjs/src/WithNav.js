import React from 'react';
import Sidenav from './Components/Sidenav';
import { Outlet } from 'react-router';
import UserProfileButton from './Components/UserProfileButton';

const WithNav = () => {
  return (
    <>
      <Sidenav />
      <UserProfileButton />
      <Outlet />
    </>
  );
};

export default WithNav;