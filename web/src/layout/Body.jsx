import React from 'react';
import TaskList from '../components/TaskList';

export default () => {
  return (
    <div id="body" className="row">
      <TaskList
        name="List1"
        cards={[
          { text: 'do something... do something... do something... do something...' },
          { text: 'do something...' },
          { text: 'do something...' },
          { text: 'do something...' },
        ]}
      />
      <TaskList name="List2" cards={[{ text: 'do something...' }, { text: 'do something...' }]} />
      <TaskList name="List3" cards={[{ text: 'do something...' }]} />
    </div>
  );
};
