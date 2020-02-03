import React from 'react';
import TaskJob from './TaskJob';

export default props => {
  return (
    <div className="list" draggable="true">
      <div className="list-heading">{props.name}</div>
      {props.cards.map((card, index) => (
        <TaskJob name={card.name} text={card.text} key={index} />
      ))}
    </div>
  );
};
