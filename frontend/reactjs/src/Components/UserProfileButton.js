import React from "react";
import { IconButton } from "@mui/material";
import { AccountCircle } from "@mui/icons-material";
import { useTheme } from "@mui/material/styles";

const UserProfileButton = () => {
  const theme = useTheme();

  const buttonStyle = {
    position: "absolute",
    top: "0",
    right: "0",
  };

  return (
    <IconButton aria-label="user-profile" style={buttonStyle}>
      <AccountCircle style={{ color: theme.palette.common.white }} fontSize="large" />
    </IconButton>
  );
};
//n

export default UserProfileButton;
