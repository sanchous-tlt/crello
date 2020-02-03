import React from 'react';
import { render } from 'react-dom';

import './styles.css';
import Header from './layout/Header';
import Body from './layout/Body';

render(
  <div>
    <Header />
    <Body />
  </div>,
  document.getElementById('app'),
);
