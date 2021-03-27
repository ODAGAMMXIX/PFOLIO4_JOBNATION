import React from 'react';
import ReactDOM from 'react-dom';
import { Carousel } from 'react-bootstrap';
import styled from 'styled-components';

const CustomCarouselItem = styled(Carousel.Item)`
    padding: 0px 15px;
    min-width: 100%;
`

export function CustomCarousel({children, activeIndex}){
    
    return (
        <Carousel interval={null} controls={false} indicators={false} activeIndex={activeIndex}>
            {
                children?.map((item, index) =>(
                    <CustomCarouselItem>
                        {item.props.children}
                    </CustomCarouselItem>
                ))
            }
        </Carousel>
    )
    
}

