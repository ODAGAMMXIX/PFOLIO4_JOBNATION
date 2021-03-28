import React from 'react';
import styled from 'styled-components';
import HeaderComponent from '../../components/Header.component';
import {Grid, CardContent, Card} from '@material-ui/core';

const Wrapper = styled('div')`
  display: flex;
`;

const MainWrapper = styled('div')`
  width: 100%;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
`;

const ContentWrapper = styled('div')`
  // padding: 15px;
  height: 100%;
`;

const MenuWrapper = styled('div')`
  width: 15%;
  min-height: 100%;
  box-shadow:0px 0px 10px rgba(0,0,0,0.05);
  position: relative;
  z-index: 2;
`;

function TemplateDefault({children}) {
  return (
    <Wrapper>
        <MenuWrapper className="default_white_background">
          menu
        </MenuWrapper>
        <MainWrapper>
          <HeaderComponent />
          <ContentWrapper className="default_light_background">
            {children}
          </ContentWrapper>
        </MainWrapper>
    </Wrapper>
  );
}

export default TemplateDefault;