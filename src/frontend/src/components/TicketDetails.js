import React, {useState, useEffect} from 'react';
import {Link} from 'react-router-dom';
import {API_BASE_URL} from '../config';

let ticketValue;

function TicketDetails(){

    const [ticket, fetchTicketDetails] = useState(0);

    const ticketDetails = () => {

        fetch(`${API_BASE_URL}/ticketDetails${window.location.search}`)
        .then(response => response.json())
        .then(json => fetchTicketDetails(json));
    }
    useEffect(() => {
        ticketDetails();
    }, []);

    const {id, description, priority, subject, type, status, } = ticket;
    ticketValue = ticket;

    return(
        <div>
            <h3>Ticket Details</h3>
            <div className = "TicketDetails">
                <div><b>Id:</b> {id}</div>
                <div><b>Subject:</b> {subject}</div>
                <div><b>Description:</b> {description}</div>
                <div><b>Priority:</b> {priority}</div>
                <div><b>Type:</b> {type}</div>
                <div><b>Status:</b> {status}</div>
            </div>
            <Link to='/tickets'>Back</Link>
        </div>
    );
}

export default TicketDetails;

export{ticketValue};