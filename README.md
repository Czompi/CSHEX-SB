# CSHEX-SB
This project is mainly created for my CV export, but I thought, that I'll share it, because it can be useful for someone as well.
It uses [iText 7 Html2Pdf](https://kb.itextpdf.com/home/it7kb/ebooks/itext-7-converting-html-to-pdf-with-pdfhtml) converter dependency to convert HTML files to PDF.

## Endpoints
### POST `/v1/convert`
#### Request
```json
{
    "url": "https://domain.hu/to/be/converted"
}
```
#### Response
A generated PDF, that can be edited by any PDF editor and it consumes less space, than a Chrome/Edge *Print to PDF* file.

###### *This is my first Spring Boot project, so it will not be perfect. I just started learning it after writing ASP.NET Core applications since 2020, so it might look a C# dev-ish. This is just a proof-of-concept and it might be part of a bigger project down on the line.*
