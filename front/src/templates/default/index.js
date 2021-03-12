import React from 'react';
import styled from 'styled-components';
import HeaderComponent from '../../components/Header.component';

const Wrapper = styled('div')`

`
function TemplateDefault({children}) {
  return (
    <Wrapper>
        <HeaderComponent />
        {children}
    </Wrapper>
  );
}

export default TemplateDefault;