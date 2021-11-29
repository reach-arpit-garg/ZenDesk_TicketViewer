import React, {useState, useEffect} from 'react';
import {Link, Redirect} from 'react-router-dom';
import {Button} from 'react-bootstrap';
import {API_BASE_URL} from '../config';
import Ticket from './TicketListDetails';

const PAGE_RANGE = 25;
let pageNumber = 0;

function TicketList(){
    const [ticketList, setList] = useState([]);
    const [ticketListLength, setTicketListLength] = useState(0);

    const fetchTicketListPage = ({start, end}) => {
        pageNumber = start / PAGE_RANGE;
        pageNumber++;

        fetch(`${API_BASE_URL}/tickets?page=${pageNumber}&per_page=${PAGE_RANGE}`)
        .then(response => response.json())
        .then(json => setList(json))
        .catch(
            (error) => {
                alert("ERROR: "+"Unexpected action!");
                return <Redirect to="/" />
            }
          );
    }

    useEffect(() => {
        fetchTicketListPage({start: 0, end: PAGE_RANGE});

        fetch(`${API_BASE_URL}/tickets/count`)
        .then(response => response.json())
        .then(json => {setTicketListLength(json);
        });
        
    }, []);

    const buttonNumbers = []
    for (let i=0; i<Math.ceil(ticketListLength/PAGE_RANGE); i++){
        buttonNumbers.push(i);
    }
    return(
        <div className="TicketList">
            <Link to='/'>Home</Link>
            <hr />
            <h3>Ticket List</h3>
            <div>
                {   
                    ticketList.map(ticket => <Ticket key={ticket.id} ticket={ticket}/>)
                }
            </div>
            <div>
                {
                    buttonNumbers.map(number =>{
                        const start = number*PAGE_RANGE;
                        const end = (number+1)*PAGE_RANGE;
                        return(
                            <span key={number}>
                                <Button size="sm" variant="danger" onClick={() => fetchTicketListPage({start, end})}>
                                    {number+1}
                                </Button>
                            </span>
                        )
                    })
                }
            </div>
        </div>
    )
}

export default TicketList;