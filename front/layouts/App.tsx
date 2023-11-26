import loadable from '@loadable/component';
import React, { FC } from 'react';
import { Route, Routes } from 'react-router-dom';

const Login = loadable(() => import('@pages/Login'));
const SignUp = loadable(() => import('@pages/SignUp'));
const Channel = loadable(() => import('@pages/Channel'));

const App = () => (
  <Routes>
    <Route path="/login" Component={Login} />
    <Route path="/signup" Component={SignUp} />
    <Route path="/workspace/channel" Component={Channel} />
  </Routes>
);

export default App;
