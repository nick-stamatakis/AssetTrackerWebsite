import React from 'react';
import Sidenav from './Components/Sidenav';
import ProtectedRoute from './Components/ProtectedRoute';
import UserProfileButton from './Components/UserProfileButton';

const WithNav = () => {
  return (
    <>
      <Sidenav />
      <UserProfileButton />
      <ProtectedRoute />
      {/*<Outlet /> 
      Uncomment this if ProtectedRoute is removed*/}
    </>
  );
};

export default WithNav