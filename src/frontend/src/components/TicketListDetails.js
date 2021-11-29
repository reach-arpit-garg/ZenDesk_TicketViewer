import React from 'react';
import {Link, Redirect} from 'react-router-dom';

function Ticket({ticket}){
    const {id, subject, description} = ticket;

    console.log(description);
    if(new String(description).valueOf() == new String("AuthorizationError").valueOf()){
        alert("ERROR: "+"Either there are no tickets or you are not authenticated.\nPlease check your login credentials.");
        console.log("routing to home");
        return <Redirect to="/" />
    }

    return(
        <div className="Ticket">
            <div>Id: {id}</div>
            <div>Subject: {subject}</div>
            <Link to={"/ticketDetails?id="+id}>View</Link>
        </div>
    );
}

export default Ticket;