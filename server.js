const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const cors = require('cors');
const port = process.env.PORT || 5000;

app.use(cors());
app.use(bodyParser.json()); // json 형태로 주고받음
app.use(bodyParser.urlencoded({extended:true}));

app.get('/api/customers', (req,res) => {
    res.send([
        {
            'id' : 1,
            'image' : 'https://placeimg.com/64/64/1',
            'name' : '김동진',
            'birthday' : '293820',
            'gender' : '남자',
            'job' : '대학생'
        },
        {
            'id' : 2,
            'image' : 'https://placeimg.com/64/64/2',
            'name' : '박누미',
            'birthday' : '293820',
            'gender' : '여자',
            'job' : '개그우먼'
        }
    ]);
})

app.listen(port, () => console.log(`Listening on port ${port}`));