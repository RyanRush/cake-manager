import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router-dom';
import axios from 'axios';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      cakes: []
    };
  }

  componentDidMount() {
    axios.get('/api/')
      .then(res => {
        this.setState({ cakes: res.data });
        console.log(this.state.cakes);
      });
  }

  render() {
    return (
      <div class="container">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">
              CAKES LIST
            </h3>
          </div>
          <div class="panel-body">
            <h4><Link to="/create"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add Cake</Link></h4>
            <table class="table table-stripe">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Description</th>
                  <th>Image</th>
                </tr>
              </thead>
              <tbody>
                {this.state.cakes.map(c =>
                  <tr>
                    <td>{c.title}</td>
                    <td>{c.description}</td>
                    <td><img src={c.image}/></td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  }
}

export default App;