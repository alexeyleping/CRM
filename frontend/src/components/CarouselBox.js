import React, {Component} from 'react';
import Carousel from 'react-bootstrap/Carousel';
import {CarouselItem} from "react-bootstrap";
import OneImg from '../assets/OneImg.jpg';
import TwoImg from '../assets/TwoImg.jpg';
import TreeImg from '../assets/TreeImg.jpg';

class CarouselBox extends Component {

    render() {
        return (
            <div>
                <Carousel>
                     <Carousel.Item>
                                <img
                                    class="img-responsive"
                                    src={OneImg}
                                    alt="freedom"
                                />
                         <Carousel.Caption>
                             <h3>freedom</h3>
                             <p>A mari usque ad mare.</p>
                         </Carousel.Caption>
                     </Carousel.Item>
                    <Carousel.Item>
                        <img
                            class="img-responsive"
                            src={TwoImg}
                            alt="uniqueness"
                        />
                        <Carousel.Caption>
                            <h3>uniqueness</h3>
                            <p>Ab ovo usque ad mala.</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            class="img-responsive"
                            src={TreeImg}
                            alt="knowledge"
                        />
                        <Carousel.Caption>
                            <h3>knowledge</h3>
                            <p>Amīcus Plato, sed magis amīca verĭtas.</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>
            </div>
        );
    }
}

export default CarouselBox;