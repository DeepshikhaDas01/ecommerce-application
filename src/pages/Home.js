import React, {useContext} from 'react';
import { ProductContext } from '../contexts/ProductContext';
import Product from '../components/Product';
import Hero from '../components/Hero';
import { useState } from 'react';
import Header from '../components/Header';
import Footer from '../components/Footer';


const Home = () => {
const { products } = useContext(ProductContext);
const [filter, setFilter] = useState(products);


const FilterProducts = () => {
  return (
  <>
    <div className="flex flex-row pl-24 pb-4 gap-x-4 justify-items-center">
     <button className="p-2 border-solid border-2 border-black " onClick={() => setFilter(products)}>
      All
     </button>
     <button
       className="p-2 border-solid border-2 border-black"
       onClick={() => filterProduct("men's clothing")}
     >
      Men's Clothing
     </button>
    <button
   
   className="p-2 border-solid border-2 border-black"
   onClick={() => filterProduct("women's clothing")}
   >
      Women's Clothing
      </button>
    <button
    className="p-2 border-solid border-2 border-black"
    onClick={() => filterProduct("electronics")}
   >
      Electronics
 </button>
 <button
 className="p-2 border-solid border-2 border-black"
 onClick={() => filterProduct("jewelery")}
 >
 Jewelery
 </button>
 </div>
 </>
 );
 };




const filterProduct = (cat) => {
const updatedList = products.filter((x) => x.category === cat);
setFilter(updatedList);
 };


const ShowProducts = () => {
 return (
  <>

 {filter.map((product) => {
 return <Product product={product} key={product.id} />;

 })}

   </>
  );
};




 return (

 <div>
  <Header/>

 <Hero />

 <section className="py-16">

 <FilterProducts />

<div className="container mx-auto">

<div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 xl:grid-cols-5 gap-[30px] max-w-sm mx-auto md:max-w-none md:mx-0">

 <ShowProducts />

 </div>

 </div>

 </section>
 <Footer />
 </div>

);

};




export default Home;