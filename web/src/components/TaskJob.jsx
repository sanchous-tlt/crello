import React from 'react';

export default props => {
  return (
    <div className="card" draggable="true">
      <div className="card-text">{props.text}</div>
    </div>
  );
};
