import logo from './logo.svg';
import './App.css';
import Todos, { GetFeedData } from './reactqueries/BoardQuery';
import MyRoute from './components/routes/MyRoute';

function App() {
  return (
    <div className="App">
      <MyRoute />
    </div>
  );
}

export default App;
