import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Switch, Route, Redirect} from 'react-router-dom';
import history from './history';
import './index.css';
import App from './components/App';
import TicketList from './components/TicketList';
import TicketDetails from './components/TicketDetails';

ReactDOM.render(
  <Router history={history}>
    <Switch>
      <Route path='/' exact component={App} />
      <Route path='/tickets' component={TicketList} />
      <Route path={'/ticketDetails/'} component={TicketDetails} />
      <Redirect to="/" />
    </Switch>
  </Router>,
  document.getElementById('root')
);
