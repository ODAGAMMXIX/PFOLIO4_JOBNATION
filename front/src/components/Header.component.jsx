import React from 'react';
import styled from 'styled-components';
import {Link} from 'react-router-dom'

const HeaderWrapper = styled('header')`
    display: flex;
    justity-component: space-between;
    width: 100%;
    background: #eee;
    padding: 15px;
`

export default function HeaderComponent(){
    return (
        <HeaderWrapper>
            <div>
                <ul>
                    <Link to='/dashboard'>Dashboard</Link>
                    <Link to='/profile'>Profile</Link>
                </ul>
            </div>
        </HeaderWrapper>
    )
}