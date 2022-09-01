import React, { useEffect, useState } from 'react';
import './App.css';

const App = () => {

  const [accounts, setAccounts] = useState([]);

  useEffect(() => {
      fetch('http://localhost:8080')
      .then(response => response.json())
      .then(data => {
        setAccounts(data);
      })
  }, [])
  return (
    <div className="App">
          {accounts.map(account =>
            <div key={account.number}>
              {account.balance}
            
            {account.transactionsList.map(transaction => 
              <li>{transaction.detail}</li>
              )}
            </div>,
          )}
    </div>
  );
}

export default App;
