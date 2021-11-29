import React from 'react';
import {Link} from 'react-router-dom';

 function App() {
  return (
    <div className="App">
      <h3>Welcome to ticket viewer</h3>
      <br />
      <Link to="/tickets">Tickets</Link>
      <br />
    </div>
  );
}

export default App;
