import Login from '@pages/Login';
import SignUp from '@pages/SignUp';
import React, { FC } from 'react';
import { Route, Routes } from 'react-router-dom';

const App = () => (
  <Routes>
    <Route path="/login" Component={Login} />
    <Route path="/signup" Component={SignUp} />
  </Routes>
);

export default App;
